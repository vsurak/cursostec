import Photo from "./photo.ts";
import IPhotoSearcher from "./iphotosearcher.ts";
import PixabayAdapter from "./pixabayadapter.ts";
import UnsplashAdapter from "./unsplashadapter.ts";

class PhotoViewer {
    private photosApis: IPhotoSearcher[] = [];

    public constructor() {
        this.photosApis.push(PixabayAdapter.getInstance());
        this.photosApis.push(UnsplashAdapter.getInstance());
    }

    public async searchForPhotos(query: string, currentPageNumber: number, imagesPerPage: number, temperature: number) : Promise<void> {
        var allPhotos: Photo[] = [];
        for (let api of this.photosApis) {
            var photosFromApi: Photo[] = await api.search(query, currentPageNumber, imagesPerPage, temperature);
            allPhotos = [...allPhotos, ...photosFromApi];
        }
        // do something with all the photos together
    }
}