class Photo {
    private id: number;
    private format: string;
    private url: string;
    private width: number;
    private height: number;

    constructor(id: number, format: string, url: string, width: number, height: number) {
        this.id = id;
        this.format = format;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    getId(): number {
        return this.id;
    }

    setId(id: number): void {
        this.id = id;
    }

    getFormat(): string {
        return this.format;
    }

    setFormat(format: string): void {
        this.format = format;
    }

    getUrl(): string {
        return this.url;
    }

    setUrl(url: string): void {
        this.url = url;
    }

    getWidth(): number {
        return this.width;
    }

    setWidth(width: number): void {
        this.width = width;
    }

    getHeight(): number {
        return this.height;
    }

    setHeight(height: number): void {
        this.height = height;
    }
}

export default Photo;