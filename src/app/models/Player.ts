export class Player {
    idPlayer: number;
    ruolo: string;
    info: string;
    idTraining: number;
    idBiomedicalData: number;
    idPerformance: number;
    idDiet: number;



    // tslint:disable-next-line:max-line-length
    constructor(idPlayer: number, ruolo: string, info: string, idTraining: number, idBiomedicalData: number, idDiet: number, idPerformance: number) {
        this.idPlayer = idPlayer;
        this.ruolo = ruolo;
        this.info = info;
        this.idTraining = idTraining;
        this.idBiomedicalData = idBiomedicalData;
        this.idDiet = idDiet;
        this.idPerformance = idPerformance;
    }

}