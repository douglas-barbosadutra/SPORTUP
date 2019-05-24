export class BiomedicalData {
    idBiomedicalData: number;
    hearthbeat: number;
    bloodPressure: number;
    height: number;
    weight: number;
    fatMass: number;
    fatFreeMass: number;
    deleted: number;




    // tslint:disable-next-line:max-line-length
    constructor(idBiomedicalData: number, hearthbeat: number, bloodPressure: number,height: number,weight: number,fatMass: number,fatFreeMass: number,deleted: number) {
        this.idBiomedicalData = idBiomedicalData;
        this.hearthbeat = hearthbeat;
        this.bloodPressure = bloodPressure;
        this.height = height;
        this.weight= weight;
        this.fatMass = fatMass;
        this.fatFreeMass=fatFreeMass;
        this.deleted=deleted;


    }

}