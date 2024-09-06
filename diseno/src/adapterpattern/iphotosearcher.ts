import Photo from "./photo.ts";

export default interface IPhotoSearcher {
    search(query: string, pageNumber: number, pageSize: number,  temperature: number): Promise<Photo[]>;
}