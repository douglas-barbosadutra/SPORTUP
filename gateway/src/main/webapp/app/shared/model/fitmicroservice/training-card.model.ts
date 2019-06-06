export interface ITrainingCard {
    id?: number;
    monday?: string;
    tuesday?: string;
    wednesday?: string;
    thursday?: string;
    friday?: string;
    saturday?: string;
    sunday?: string;
    idPlayer?: number;
}

export class TrainingCard implements ITrainingCard {
    constructor(
        public id?: number,
        public monday?: string,
        public tuesday?: string,
        public wednesday?: string,
        public thursday?: string,
        public friday?: string,
        public saturday?: string,
        public sunday?: string,
        public idPlayer?: number
    ) {}
}
