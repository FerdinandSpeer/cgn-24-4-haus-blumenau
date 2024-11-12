import {useEffect, useState} from "react";
import "./AdminGuestList.css"
import {GuestGroup} from "../../type/GuestGroup.ts";
import axios from "axios";
import AdminGuestListForm from "../adminGuestListForm/AdminGuestListForm.tsx";


export default function AdminGuestList() {

    const [adminGuestList, setAdminGuestList] = useState<GuestGroup[]>([]);
    const [guestGroupToEdit, setGuestGroupToEdit] = useState<GuestGroup | null>(null);

    function fetchGuestGroupList() {
        axios.get<GuestGroup[]>("/api/guestGroup")
            .then(response => {console.log(response.data);
                setAdminGuestList(response.data)})
            .catch(err => console.log(err));
    }

    function deleteGuestGroup(id: string) {
        axios.delete(`/api/guestGroup/${id}`)
            .then(() => fetchGuestGroupList())
            .catch(err => console.log(err));
    }


    useEffect(() => {
        fetchGuestGroupList();
    }, []);

    return (
        <div className={"AdminGuestList"}>
    <h1>Gästegruppen:</h1>
    <ul>
        {adminGuestList.map((guest) => {
            if (guest.guests.length > 0) {
                return <li key={guest.groupId}> {guest.guests[0].groupName},
                    Anzahl: {guest.guests.length}
                    <br/>
                    <button className={"deleteButton styledButton"}
                            onClick={() => deleteGuestGroup(guest.groupId ?? "")}>Löschen
                    </button>
                    <button className={"confirmButton styledButton"}>Bestätigen</button>
                    <button className={"declineButton styledButton"}>Ablehnen</button>
                    <button className={"editButton styledButton"} onClick={()=> setGuestGroupToEdit(guest)}>Bearbeiten</button>
                </li>
            }
        })}
    </ul>
            {guestGroupToEdit !== null ?
                <div className={"adminGuestListForm"}>
                    <AdminGuestListForm guestGroupToEdit={guestGroupToEdit} fetchGuestList={fetchGuestGroupList} setGuestGroupToEdit={setGuestGroupToEdit} setAdminGuestList={setAdminGuestList}/>
                </div> : null}
        </div>

    )
}
