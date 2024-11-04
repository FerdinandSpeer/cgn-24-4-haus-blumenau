import "./AdminGuestlistForm.css";
import axios from "axios";
import {GuestGroup} from "../../type/GuestGroup.ts";


type AdminGuestListFormProps = {
    guestGroupToEdit: GuestGroup;
    fetchGuestList: () => void;
    setGuestGroupToEdit: (guestGroup: GuestGroup | null) => void;
    setAdminGuestList: (guestGroup: GuestGroup[]) => void;
}

function AdminGuestListForm(props: AdminGuestListFormProps) {


    function handleDeleteGuest (guestId: string) {
        props.setGuestGroupToEdit({groupId: props.guestGroupToEdit.groupId,
            guests: props.guestGroupToEdit.guests.filter(
                (guest) => guest.guestId!==guestId
            ) });
    }

    function handleEditGuestGroup() {
        if (props.guestGroupToEdit !== null) {
            axios.put(`/api/guestGroup/${props.guestGroupToEdit.groupId}`, props.guestGroupToEdit)
                .then(() => props.fetchGuestList())
                .catch(err => console.log(err));
        }
    }

    return (
        <div className={"AdminGuestListForm"}>
            <h2>Gruppe: </h2>
            <div>
                <ol>
                    {props.guestGroupToEdit?.guests.map((guest) => {console.log(guest);
                        return <li key={guest.guestId}>{guest.firstName} {guest.lastName}
                            <button type={"button"} onClick={()=>handleDeleteGuest(guest.guestId)}>Löschen</button>
                        </li>
                    })}
                </ol>
                <button className={"styledButton"} onClick={()=>handleEditGuestGroup()}>Speichern</button>
                <button className={"styledButton"} onClick={() => {
                    props.fetchGuestList();
                    props.setGuestGroupToEdit(null)}}>Abbrechen</button>
            </div>
        </div>
    );
}

export default AdminGuestListForm;