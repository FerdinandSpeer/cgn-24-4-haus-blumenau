import "./GuestGroupDashboard.css"
import NavBar from "../../components/navBar/NavBar.tsx";
import axios from "axios";
import {GuestGroup} from "../../type/GuestGroup.ts";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";


export default function GuestGroupDashboard() {

    const {groupId} = useParams<{ groupId: string }>();
    const [guestGroup, setGuestGroup] = useState<GuestGroup | null>(null);


    function fetchGuestGroupById(groupId: string) {
        axios.get<GuestGroup>(`/api/guestGroup/${groupId}`)
            .then(response => {
                setGuestGroup(response.data);
            })
            .catch(err => console.log(err));

    }

    useEffect(() => {
        if (groupId) {
            fetchGuestGroupById(groupId);
        }
    }, [groupId]);

    return (
        <>
            <NavBar/>
            <h1>Willkommen im Haus Blumen-Au</h1>
            <div className={"bodyGuestGroupDashboard"}>
                <h2>Gästeliste</h2>
                <div className={"list"}>
                    <ol className={"guestGroupList"}>
                        {guestGroup?.guests.map((guest, index) => (
                            <li key={index}>
                                {guest.firstName} {guest.lastName}
                                <button>Bearbeiten</button>
                            </li>
                        ))}
                    </ol>
                </div>
            </div>

            <div className={"bodyWeatherBookingTime"}>
                <div className={"weatherApi"}>
                    <h2>Wetter Schönau am Königssee</h2>
                    <p>Hier zeigt die api die Daten vom Wetter an.</p>
                </div>

                <div className={"bookingTime"}>
                    <h2>Buchungszeitraum</h2>
                    <p> arrivalDate - departureDate</p>
                </div>
            </div>
        </>
    )
}