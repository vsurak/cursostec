import Photo from "./photo.ts";

class PixabayApiClient {
    private static instance: PixabayApiClient;
    private static KEY = 'YOURAPIKEY';
    private imagesPerPage : number = 25;
    
    private constructor(pImagesPerPage: number) {
        // Private constructor to prevent instantiation
        this.imagesPerPage = pImagesPerPage;
    }
    
    public static getInstance(pImagesPerPage: number): PixabayApiClient {
        if (!PixabayApiClient.instance) {
            PixabayApiClient.instance = new PixabayApiClient(pImagesPerPage);
        }
        return PixabayApiClient.instance;
    }
    
    public searchImages(query: string, currentPageNumber: number): Promise<Photo[]> {
        // Implement your logic to search images using the Pixabay API here
        // Return a Promise that resolves with the search results

        return fetch(`https://pixabay.com/api/?key=${PixabayApiClient.KEY}&q=${query}&page=${currentPageNumber}}&per_page=${this.imagesPerPage}&order=popular`)
            .then(response => response.json())
            .then(data => {
                const photos: Photo[] = data.hits.map((hit: any) => {
                    const photo = new Photo(hit.id, hit.format, hit.imageURL, hit.imageWidth, hit.imageHeight);
                    return photo;
                });
                return photos;
            });
    }

    public setImagesPerPage(imagesPerPage: number): void {
        this.imagesPerPage = imagesPerPage;
    }
}

export default PixabayApiClient;