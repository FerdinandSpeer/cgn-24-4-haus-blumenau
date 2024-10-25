import {useEffect, useState} from "react";
import "./AdminGuestList.css"
import {GuestGroup} from "../../type/GuestGroup.ts";
import axios from "axios";


export default function AdminGuestList() {

    const [adminGuestList, setAdminGuestList] = useState<GuestGroup[]>([]);

    function fetchGuestList() {
        axios.get<GuestGroup[]>("/guestGroup")
            .then(response => setAdminGuestList(response.data))
            .catch(err => console.log(err));
    }

    function deleteGuestGroup(id: string) {
        axios.delete(`/guestGroup/${id}`)
            .then(() => fetchGuestList())
            .catch(err => console.log(err));
    }


    useEffect(() => {
        fetchGuestList();
    }, []);

    return (
        <div className={"AdminGuestList"}>
    <h1>Gästegruppen:</h1>
    <ul>
        {adminGuestList.map((guest) => {
            if (guest.guestsDTO.length > 0) {
                return <li key={guest.id}> {guest.guestsDTO[0].groupName},
                    Anzahl: {guest.guestsDTO.length}
                    <br/>
                    <button className={"deleteButton styledButton"} onClick={()=>deleteGuestGroup(guest.id ?? "")}>Löschen</button>
                    <button className={"confirmButton styledButton"}>Bestätigen</button>
                    <button className={"declineButton styledButton"}>Ablehnen</button>
                </li>
            }
        })}
    </ul>
</div>

    )
}
