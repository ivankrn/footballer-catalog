import { CountryName } from "./country";
import { GenderName } from "./gender";
import { Team } from "./team.model";

export interface Footballer {
    id?: number;
    firstName: string;
    lastName: string;
    gender: GenderName;
    birthdate: Date;
    team?: Team;
    teamId?: number;
    country: CountryName;
}