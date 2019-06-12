export class Player {
    id: number;
    ruolo: string;
    info: string;
    idUser: number;
    idBiomedicalData: number;
    idPerformance: number;
    



    // tslint:disable-next-line:max-line-length
    constructor(id: number, ruolo: string, info: string, idUser: number, idBiomedicalData: number, idPerformance: number) {
        this.id = id;
        this.ruolo = ruolo;
        this.info = info;
        this.idUser = idUser;
        this.idBiomedicalData = idBiomedicalData;
        this.idPerformance = idPerformance;
    }

}