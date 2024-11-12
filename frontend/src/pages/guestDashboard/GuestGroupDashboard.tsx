import "./GuestGroupDashboard.css"
import NavBar from "../../components/navBar/NavBar.tsx";
import axios from "axios";
import {GuestGroup} from "../../type/GuestGroup.ts";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import GuestGroupListById from "../../components/guestGroupListById/GuestGroupListById.tsx";


export default function GuestGroupDashboard() {

    const {groupId} = useParams<{ groupId: string }>();
    const [guestGroup, setGuestGroup] = useState<GuestGroup | null>(null);

    /**
     * Ruft eine Gästegruppe anhand der Gruppen-ID vom Server ab und speichert sie im State.
     *
     * Diese Funktion sendet eine GET-Anfrage an den API-Endpunkt `/api/guestGroup/{groupId}`
     * und aktualisiert den State mit den empfangenen Daten. Bei einem Fehler wird dieser im
     * Konsolenprotokoll angezeigt.
     *
     * @param {string} groupId - Die eindeutige ID der Gästegruppe, die abgerufen werden soll.
     * @returns {void} Diese Funktion gibt keinen Wert zurück.
     *
     * @throws {Error} Wenn die Anfrage fehlschlägt, wird der Fehler in der Konsole protokolliert.
     */
    function fetchGuestGroupById(groupId: string): void {
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
                <GuestGroupListById guestGroup={guestGroup} />
            </div>

            <div className={"bodyWeatherBookingTime"}>
                <div className={"weatherApi"}>
                    <h2>Wetter Schönau am Königssee</h2>
                    <p> ...Hier soll das Wetter für 7-Tage stehen...</p>
                </div>

                <div className={"bookingTime"}>
                    <h2>Buchungszeitraum</h2>
                    <p> arrivalDate - departureDate</p>
                </div>
            </div>
        </>
    )
}