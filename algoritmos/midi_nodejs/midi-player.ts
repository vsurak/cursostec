/**
 * Filename: midi-player.ts
 * Author: rnunez
 * Date: 03/21/2019
 * Description: main program file
 */

import { File, Track } from 'jsmidgen';
import * as fs from 'fs';

const MIDINOTE_POSITION = 0;
const DURATION_POSITION = 1;
const TIME_POSITION = 2;
const BEATS_PER_MINUTE = 120;
const TICKS_PER_BEAT = 128;
const TICKS_PER_SECOND = (BEATS_PER_MINUTE / 60) * TICKS_PER_BEAT;

export class MidiPlayer {
  private song: number[][];

  public constructor(pSong: number[][]) {
    this.song = this.sortSong(pSong);
  }

  public buildMidiFile() : void {
    var file = new File();
    var track = new Track();
    var prevWait = 0;
    track.setTempo(BEATS_PER_MINUTE);
    file.addTrack(track);
    this.song.forEach(note => {
      track.addNote(0, 
                    note[MIDINOTE_POSITION], 
                    note[DURATION_POSITION] / 1000 * TICKS_PER_SECOND, 
                    1);
      //prevWait = prevWait - note[TIME_POSITION];
    });
    fs.writeFileSync('test.midi', file.toBytes(), 'binary');
    console.log("Midi generado");
  }

  private sortSong(pSong: number[][]) : number[][] {
    return pSong.sort((noteA: number[], noteB: number[]) => {
      
      if (noteA[TIME_POSITION] > noteB[TIME_POSITION]) {
        return 1;
      } 

      if (noteA[TIME_POSITION] < noteB[TIME_POSITION]) {
        return -1;
      } 

      return 0;
    });
  }
}
