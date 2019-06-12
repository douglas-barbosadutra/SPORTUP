export class TrainingCard {
    idTrainingCard: number;
    monday: string;
    tuesday: string;
    wednesday: string;
    thursday: string;
    friday: string;
    saturday: string;
    sunday: string;
    deleted: number;
    idPlayer: number;



    // tslint:disable-next-line:max-line-length
    constructor(idTrainingCard: number, monday: string, tuesday: string, wednesday: string, thursday: string, friday: string, saturday: string, sunday: string, deleted: number, idPlayer: number) {
        this.idTrainingCard = idTrainingCard;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.deleted = deleted;
        this.idPlayer = idPlayer;
    }

}