export enum Gender {
    MALE = "Мужской",
    FEMALE = "Женский"
}
export type GenderName = keyof typeof Gender;