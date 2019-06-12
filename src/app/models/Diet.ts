export class Daily {
    id: number;
    day: string;
    breakfast: string;
    snack: string;
    lunch: string;
    snackAfternoon: string;
    dinner: string;
    idPlayer: number;
    
    



    // tslint:disable-next-line:max-line-length
    constructor(id: number, day: string, breakfast: string, snack: string, lunch: string, snackAfternoon: string, dinner: string, idPlayer: number) {
        this.id = id;
        this.day = day;
        this.breakfast = breakfast;
        this.snack = snack;
        this.lunch = lunch;
        this.snackAfternoon = snackAfternoon;
        this.dinner = dinner;
        this.idPlayer = idPlayer;
        
    }

}