import IPhotoSearcher from "./iphotosearcher.ts";
import Photo from "./photo.ts";
import UnsplashApiClient from "./unsplash.ts";

    


class UnSplashAdapter implements IPhotoSearcher {
    private static instance: UnSplashAdapter;
    private unsplashApiClient: UnsplashApiClient;
    
    private constructor() {
        this.unsplashApiClient = UnsplashApiClient.getInstance();
    }
    
    public static getInstance(): UnSplashAdapter {
        if (!UnSplashAdapter.instance) {
            UnSplashAdapter.instance = new UnSplashAdapter();
        }
        return UnSplashAdapter.instance;
    }
    
    public search(query: string, pageNumber: number, pageSize: number, temperature: number): Promise<Photo[]> {
        var filter = temperature > 30 ? "high" : "low";
        return this.unsplashApiClient.searchPhotos(query, pageNumber, pageSize, "latest", filter);
    }
        
}

export default UnSplashAdapter;