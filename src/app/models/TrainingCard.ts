export class TrainingCard {
    idTrainingCard: number;
    idTraining: number;
    monday: string;
    tuesday: string;
    wednesday: string;
    thursday: string;
    friday: string;
    saturday: string;
    sunday: string;
    deleted: number;



    // tslint:disable-next-line:max-line-length
    constructor(idTrainingCard: number, idTraining: number, monday: string, tuesday: string, wednesday: string, thursday: string, friday: string, saturday: string, sunday: string, deleted: number) {
        this.idTrainingCard = idTrainingCard;
        this.idTraining = idTraining;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.deleted = deleted;
    }

}