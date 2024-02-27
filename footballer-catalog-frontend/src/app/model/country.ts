export enum Country {
    USA = "США",
    ITALY = "Италия",
    RUSSIA = "Россия",
}
export type CountryName = keyof typeof Country;