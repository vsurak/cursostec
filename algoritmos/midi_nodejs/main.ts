/**
 * Filename: main.ts
 * Author: rnunez
 * Date: 03/21/2019
 * Description: main program file
 */

import {MidiPlayer} from './midi-player';

const SONG_DURATION = 2 *  60 * 1000; // 2 minutes song milisegundos
const minNoteDuration = 200;
const noteDuration = 1200; // 1.2 seconds note
const song : number[][] = []; // [[midiNote, duration, timeline]]
const minNote = 20;
const maxNote = 120;
const NOTES_PER_SECOND = 5;
const AMOUNT_OF_NOTES = SONG_DURATION / 1000 * NOTES_PER_SECOND;

const playSong = new Promise<number[][]>((resolve, reject) => {
  for (let i = 0; i < AMOUNT_OF_NOTES; i++) { // intentando que el random me lleve a 3 notas overlap en los mismos 2 segundos
    song.push([
      Math.floor(Math.random() * (maxNote - minNote) + minNote), // note
      Math.floor(Math.random() * (noteDuration - minNoteDuration) + minNoteDuration), // note duration
      Math.random() * SONG_DURATION]); // timeline
  }
  if (song.length === AMOUNT_OF_NOTES) {
    resolve(song);
  } else {
    reject(song);
  }
})
.then((song: number[][]) => {
  const player = new MidiPlayer(song);
  player.buildMidiFile();
})
.catch(((song: number[][]) => {
  console.log("no se genero bien la cancion");
}))

