import Photo from "./photo.ts";
import PixabayApiClient from "./pixabay.ts";
import UnsplashApiClient from "./unsplash.ts";

class PhotoViewer {
    private pixabayApiClient: PixabayApiClient;
    private unsplashApiClient: UnsplashApiClient;

    public constructor() {
        this.pixabayApiClient = PixabayApiClient.getInstance(25);
        this.unsplashApiClient = UnsplashApiClient.getInstance();
    }

    public async searchForPhotos(query: string, currentPageNumber: number, imagesPerPage: number, temperature: number) : Promise<void> {

        var filter = temperature > 30 ? "high" : "low";

        var photosFromUnplash : Photo[] = await this.unsplashApiClient.searchPhotos(query, currentPageNumber, imagesPerPage, "latest", filter);

        this.pixabayApiClient.setImagesPerPage(imagesPerPage);
        var photosFromPixabay : Photo[] = await this.pixabayApiClient.searchImages(query, currentPageNumber);

        const allPhotos: Photo[] = [...photosFromUnplash, ...photosFromPixabay];

        // do something with all the photos together
    }
}