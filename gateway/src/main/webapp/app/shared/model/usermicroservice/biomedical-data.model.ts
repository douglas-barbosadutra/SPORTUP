export interface IBiomedicalData {
    id?: number;
    hearthbeat?: number;
    bloodPressure?: number;
    height?: number;
    weight?: number;
    fatMass?: number;
    fatFreeMass?: number;
}

export class BiomedicalData implements IBiomedicalData {
    constructor(
        public id?: number,
        public hearthbeat?: number,
        public bloodPressure?: number,
        public height?: number,
        public weight?: number,
        public fatMass?: number,
        public fatFreeMass?: number
    ) {}
}
