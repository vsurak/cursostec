export class Package {
    private _id: string;
    private _weight: number;
    private _type: string;
    private _career: string;
    private _costList: any;

    constructor(id: string, weight: number, type: string, career: string, costList: any) {
        this._id = id;
        this._weight = weight;
        this._type = type;
        this._career = career;
        this._costList = costList;
    }

    get id(): string {
        return this._id;
    }

    set id(value: string) {
        this._id = value;
    }

    get weight(): number {
        return this._weight;
    }

    set weight(value: number) {
        this._weight = value;
    }

    get type(): string {
        return this._type;
    }

    set type(value: string) {
        this._type = value;
    }

    get career(): string {
        return this._career;
    }

    set career(value: string) {
        this._career = value;
    }

    get costList(): any {
        return this._costList;
    }
}
