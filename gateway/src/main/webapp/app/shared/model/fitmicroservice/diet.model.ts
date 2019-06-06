export interface IDiet {
    id?: number;
    day?: string;
    breakfast?: string;
    snack?: string;
    lunch?: string;
    snackAfternoon?: string;
    dinner?: string;
    idPlayer?: number;
}

export class Diet implements IDiet {
    constructor(
        public id?: number,
        public day?: string,
        public breakfast?: string,
        public snack?: string,
        public lunch?: string,
        public snackAfternoon?: string,
        public dinner?: string,
        public idPlayer?: number
    ) {}
}
