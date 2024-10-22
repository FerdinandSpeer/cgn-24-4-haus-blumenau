import {Guest} from "./Guest.ts";

export type GuestGroup = {
    id: string | undefined,
    guestsDTO: Guest[]
}