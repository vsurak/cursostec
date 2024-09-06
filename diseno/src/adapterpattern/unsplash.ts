import Photo from "./photo.ts";

class UnsplashApiClient {
    private static instance: UnsplashApiClient;
    
    private constructor() {
        // Private constructor to prevent instantiation
    }
    
    public static getInstance(): UnsplashApiClient {
        if (!UnsplashApiClient.instance) {
            UnsplashApiClient.instance = new UnsplashApiClient();
        }
        return UnsplashApiClient.instance;
    }
    
    public searchPhotos(query: string, pageNumber: number, pageSize: number, orderBy: string, filter: string): Promise<Photo[]> {
        // Implement your logic to search images using the Pixabay API here
        // Return a Promise that resolves with the search results

        return fetch(`https://unsplash.com/api/v3/search/photos?page=${pageNumber}&query=${query}&per_page=${pageSize}&order_by=${orderBy}&content_filter=${filter}`)
            .then(response => response.json())
            .then(data => {
                const photos: Photo[] = data.results.map((resultPhoto: any) => {
                    const photo = new Photo(resultPhoto.id, "unknown", resultPhoto.urls.full, resultPhoto.width, resultPhoto.height);
                    return photo;
                });
                return photos;
            });
    }
}

export default UnsplashApiClient;