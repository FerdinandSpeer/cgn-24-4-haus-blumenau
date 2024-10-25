import {Guest} from "../../type/Guest.ts";
import "./GuestList.css"

type GuestListProps = {
    guests: Guest[]

}

export default function GuestList(props: GuestListProps) {


    return (
        <div>
            <h2>Gäste Liste:</h2>
            <ol id={"guestList"}>
                {props.guests.map((guest) => {
                    return<li key={guest.id}>{guest.firstName} {guest.lastName}</li>
                })}
            </ol>
        </div>
    )
}