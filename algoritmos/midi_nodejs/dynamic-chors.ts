const DISTANCE_CHORS = 400;

export class chors {
  private song: number[][];


  public constructor(pSong: number[][]) {
    this.song = pSong;
  }

  public dynamicNormalize() {
    this.normalize(this.song, DISTANCE_CHORS, 0);
  }

  private normalize(pSong: number[][], pDistance: number, pIndex: number) {
    // hago el analisis de 3 notas para armar acorde
    // modifico el nuevo indice en pIndex
    this.normalize(pSong, pDistance, pIndex);
  }
}