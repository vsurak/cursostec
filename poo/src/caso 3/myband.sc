/*
 myband.sc - three synths + loader + test

 Usage (SuperCollider IDE): open this file and evaluate it with Ctrl+Enter
 inside the parenthesis block below. Then:

   ~myband.load;                              // boots server, adds SynthDefs
   ~myband.test;                              // plays a short demo of all 3

   ~myband.piano(48, 2000);                   // C3 major chord, 2000 ms
   ~myband.piano(57, 2000, 3);                // A3 minor chord (third = 3 semitones)
   ~myband.bass(36, 800);                     // C2 string bass, 800 ms
   ~myband.noteOn(60);                        // 70's organ, default partials 1/2/3
   ~myband.noteOn(64, [1, 2.01, 4], [1, 0.6, 0.3]);  // custom partial ratios / amps
   ~myband.noteOff(60);
   ~myband.noteOff(64);

 All "note" arguments are MIDI note numbers, durations are in milliseconds.
*/

(
~myband = ();

~myband[\active] = Dictionary.new;   // midi note -> running organ synth

// ---------------------------------------------------------------- SynthDefs
~myband[\defs] = {

	// 1) Classic piano: chord built from one fundamental note.
	//    Chord = root, third (major=4 / minor=3), fifth, octave.
	//    Attack and decay are hardcoded; durMs is the total length.
	SynthDef(\classicPiano, { |out = 0, note = 48, durMs = 1500, amp = 0.3, third = 4|
		var atk = 0.005, dur, freqs, env, tone, hammer, cutoff;
		dur = durMs / 1000;
		freqs = (note + [0, third, 7, 12]).midicps;

		// percussive envelope: fast attack, exponential-ish decay for the rest
		env = EnvGen.ar(
			Env([0, 1, 0], [atk, (dur - atk).max(0.01)], [-2, -5]),
			doneAction: 2
		);

		// 4 harmonics per chord note, slightly stretched (string inharmonicity)
		tone = Mix.fill(4, { |n|
			var h = n + 1;
			SinOsc.ar(freqs * h * (1 + (0.0004 * h * h)), 0, [1, 0.5, 0.25, 0.12][n])
		});

		// brightness fades as the note decays
		cutoff = XLine.kr(6000, 900, dur);
		tone = LPF.ar(tone, cutoff);

		// hammer thump
		hammer = BPF.ar(WhiteNoise.ar, 2500, 0.8) * EnvGen.ar(Env.perc(0.001, 0.02)) * 0.15;

		Out.ar(out, Splay.ar(tone * env * amp * 0.5) + (hammer ! 2 * amp));
	}).add;

	// 2) String bass (Karplus-Strong pluck + a bit of sub body).
	SynthDef(\stringBass, { |out = 0, note = 36, durMs = 1000, amp = 0.5|
		var dur, freq, env, exc, pluck, body, sig;
		dur = durMs / 1000;
		freq = note.midicps;

		env = EnvGen.ar(Env([1, 1, 0], [dur, 0.08], [0, -4]), doneAction: 2);

		exc = LPF.ar(WhiteNoise.ar, 3000) * EnvGen.ar(Env.perc(0.001, 0.01));
		pluck = Pluck.ar(exc, Impulse.ar(0), 0.1, freq.reciprocal, dur * 1.5, 0.45);
		body = SinOsc.ar(freq, 0, 0.25) * EnvGen.ar(Env.perc(0.005, dur, 1, -4));

		sig = LPF.ar(pluck + body, 1400);
		sig = (sig * 1.5).tanh * 0.7;

		Out.ar(out, (sig * env * amp) ! 2);
	}).add;

	// 3) 70's organ: three partials set by parameter, sustained until gate = 0.
	//    "Magnetic" feel: slow tape-like drift per partial, delayed vibrato,
	//    detuned twin oscillators (phasing) and soft saturation.
	SynthDef(\organ70s, { |out = 0, freq = 220, amp = 0.3, gate = 1,
		r1 = 1, r2 = 2, r3 = 3,
		a1 = 1, a2 = 0.5, a3 = 0.25,
		vibRate = 5.5, vibDepth = 0.004, atk = 0.03, rel = 0.5|
		var ratios, amps, vib, env, sig;
		ratios = [r1, r2, r3];
		amps = [a1, a2, a3];

		// vibrato fades in after a moment, like old organs
		vib = SinOsc.kr(vibRate, 0, vibDepth) * Line.kr(0, 1, 0.8);

		sig = Mix.fill(3, { |i|
			var drift = LFNoise2.kr(0.6 + (i * 0.3), 0.0025);   // slow analog wobble
			var f = freq * ratios[i] * (1 + vib + drift);
			(SinOsc.ar(f) + SinOsc.ar(f * 1.003, 1)) * 0.5 * amps[i]
		});

		sig = sig * (1 + SinOsc.kr(6.5, 0, 0.06));              // slight tremolo
		sig = (sig * 1.8).tanh;                                 // warm saturation
		sig = LPF.ar(sig, 3800);
		sig = sig + (HPF.ar(PinkNoise.ar(0.004), 2000));        // faint tape hiss

		env = EnvGen.kr(Env.asr(atk, 1, rel), gate, doneAction: 2);
		Out.ar(out, (sig * env * amp) ! 2);
	}).add;
};

// ------------------------------------------------------------------ loader
~myband[\load] = { |self, onLoaded|
	fork {
		Server.default.bootSync;
		self.defs.value;
		Server.default.sync;
		"myband: classicPiano, stringBass, organ70s loaded".postln;
		onLoaded.value;
	};
};

// ------------------------------------------------------------- player API
~myband[\piano] = { |self, note = 48, durMs = 1500, third = 4, amp = 0.3|
	Synth(\classicPiano, [\note, note, \durMs, durMs, \third, third, \amp, amp]);
};

~myband[\bass] = { |self, note = 36, durMs = 1000, amp = 0.5|
	Synth(\stringBass, [\note, note, \durMs, durMs, \amp, amp]);
};

~myband[\noteOn] = { |self, note = 60, ratios = #[1, 2, 3], amps = #[1, 0.5, 0.25], amp = 0.3|
	self.noteOff(note);   // retrigger safely
	self.active[note] = Synth(\organ70s, [
		\freq, note.midicps, \amp, amp,
		\r1, ratios[0], \r2, ratios[1], \r3, ratios[2],
		\a1, amps[0], \a2, amps[1], \a3, amps[2]
	]);
};

~myband[\noteOff] = { |self, note = 60|
	var syn = self.active.removeAt(note);
	if(syn.notNil) { syn.set(\gate, 0) };
};

// -------------------------------------------------------------------- test
~myband[\test] = { |self|
	self.load({
		fork {
			"-- piano: C major, A minor, F major".postln;
			self.piano(48, 1500);          1.7.wait;
			self.piano(57, 1500, 3);       1.7.wait;
			self.piano(53, 2000);          2.3.wait;

			"-- string bass: C - G - A - F".postln;
			[36, 43, 45, 41].do { |n| self.bass(n, 450); 0.5.wait };
			0.5.wait;

			"-- organ 70s: noteOn / noteOff".postln;
			self.noteOn(60);                                   1.5.wait;
			self.noteOn(64, [1, 2.01, 4], [1, 0.6, 0.3]);      1.5.wait;
			self.noteOn(67, [1, 3, 5], [1, 0.4, 0.2]);         2.0.wait;
			self.noteOff(60); self.noteOff(64); self.noteOff(67);
			1.0.wait;
			"myband: test done".postln;
		};
	});
};
)

~myband.load;
~myband.test;
