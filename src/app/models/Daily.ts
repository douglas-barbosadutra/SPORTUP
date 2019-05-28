export class Daily {
    day: string;
    breakfast: string;
    snack: string;
    lunch: string;
    snackAfternoon: string;
    dinner: string;
    idDay: number;
    idDiet: number;
    



    // tslint:disable-next-line:max-line-length
    constructor(day: string, breakfast: string, snack: string, lunch: string, snackAfternoon: string, dinner: string, idDiet: number, idDay: number) {
        this.day = day;
        this.breakfast = breakfast;
        this.snack = snack;
        this.lunch = lunch;
        this.snackAfternoon = snackAfternoon;
        this.dinner = dinner;
        this.idDay = idDay;
        this.idDiet = idDiet;
        
    }

}