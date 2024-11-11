import {GuestGroup} from "../../type/GuestGroup.ts";

type GuestGroupListByIdProps = {
    guestGroup: GuestGroup | null;
}

export default function GuestGroupListById(props:GuestGroupListByIdProps){
    return (
        <>
            <h2>Gästeliste</h2>
            <div className={"list"}>
                <ol className={"guestGroupList"}>
                    {props.guestGroup?.guests.map((guest, index) => (
                        <li key={index}>
                            {guest.firstName} {guest.lastName}
                            <button>Bearbeiten</button>
                        </li>
                    ))}
                </ol>
            </div>
        </>
    )
}