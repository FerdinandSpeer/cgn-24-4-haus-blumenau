import "./AdminGuestlistForm.css";
import axios from "axios";
import {GuestGroup} from "../../type/GuestGroup.ts";


type AdminGuestListFormProps = {
    guestGroupToEdit: GuestGroup | null;
    fetchGuestList: () => void;
}

function AdminGuestListForm(props: AdminGuestListFormProps) {


    function handleDeleteGuest(id: string) {
        console.log(id);
        if (props.guestGroupToEdit !== null) {
            axios.delete(`/guest/${id}`)
                .then(() => props.fetchGuestList())
                .catch(err => console.log(err));
        }
    }

    function handleEditGuestGroup() {
        if (props.guestGroupToEdit !== null) {
            axios.put(`/guest/${props.guestGroupToEdit.id}`)
                .then(() => props.fetchGuestList())
                .catch(err => console.log(err));
        }
    }


    return (
        <div className={"AdminGuestListForm"}>
            <h2>Gruppe: </h2>
            <div>
                <ol>
                    {props.guestGroupToEdit?.guestsDTO.map((guest) => {console.log(guest);
                        return <li key={guest.id + '-' + guest.firstName}>{guest.firstName} {guest.lastName}
                            <button type={"button"} onClick={()=>handleDeleteGuest(guest.id)}>Löschen</button>
                        </li>
                    })}
                </ol>
                <button className={"styledButton"} onClick={handleEditGuestGroup}>Speichern</button>
                <button className={"styledButton"} onClick={() => props.fetchGuestList}>Abbrechen</button>
            </div>
        </div>
    );
}

export default AdminGuestListForm;