import {useEffect, useState} from "react";
import {GuestGroup} from "../../type/GuestGroup.ts";
import axios from "axios";


export default function AdminGuestList(){

    const [adminGuestList, setAdminGuestList] = useState<GuestGroup[]>([]);

    function fetchGuestList() {
        axios.get<GuestGroup[]>("/guestGroup")
            .then(response => setAdminGuestList(response.data))
            .catch(err => console.log(err));
    }

    useEffect(() => {
        fetchGuestList();
    }, []);

    return (
        <div>
            <h1>Admin Guest List</h1>
            <p>Guest List will be displayed here:</p>
            <ul>
                {adminGuestList.map((guestGroup, index) => (
                    <li key={index}>{guestGroup.guests}</li>
                ))}
            </ul>

        </div>
    );
}