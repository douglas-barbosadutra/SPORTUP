export class BiomedicalData {
    id: number;
    hearthbeat: number;
    bloodPressure: number;
    height: number;
    weight: number;
    fatMass: number;
    fatFreeMass: number;
    deleted: number;




    // tslint:disable-next-line:max-line-length
    constructor(id: number, hearthbeat: number, bloodPressure: number,height: number,weight: number,fatMass: number,fatFreeMass: number,deleted: number) {
        this.id = id;
        this.hearthbeat = hearthbeat;
        this.bloodPressure = bloodPressure;
        this.height = height;
        this.weight= weight;
        this.fatMass = fatMass;
        this.fatFreeMass=fatFreeMass;
        this.deleted=deleted;


    }

}