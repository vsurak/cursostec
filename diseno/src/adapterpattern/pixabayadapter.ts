import IPhotoSearcher from './iphotosearcher';
import Photo from './photo';
import PixabayApiClient from "./pixabay.ts";


class PixabayAdapter implements IPhotoSearcher {
    private static instance: PixabayAdapter;
    private pixabayApiClient: PixabayApiClient;

    private constructor() {
        this.pixabayApiClient = PixabayApiClient.getInstance(25);
    }
    
    public static getInstance(): PixabayAdapter {
        if (!PixabayAdapter.instance) {
            PixabayAdapter.instance = new PixabayAdapter();
        }
        return PixabayAdapter.instance;
    }
    
    public search(query: string, pageNumber: number, pageSize: number,  temperature: number): Promise<Photo[]> {
        this.pixabayApiClient.setImagesPerPage(pageSize);
        return this.pixabayApiClient.searchImages(query, pageNumber);
    }
}

export default PixabayAdapter;