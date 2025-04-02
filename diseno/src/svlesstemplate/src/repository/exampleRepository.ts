class ExampleRepository {
    private dataStore: any[] = [];

    getData(): any[] {
        return this.dataStore;
    }

    saveData(data: any): void {
        this.dataStore.push(data);
    }
}

export default ExampleRepository;