import "./GuestGroupDashboard.css"
import NavBar from "../../components/navBar/NavBar.tsx";


export default function GuestGroupDashboard() {
    return (
        <>
            <NavBar/>
            <h1>Hallo groupName Gruppe</h1>
            <div className={"bodyGuestGroupDashboard"}>
                <div className={"list"}>
                    <ol className={"guestGroupList"}>
                        <h2>Gästeliste</h2>
                        <li> Hans Hubert <button>Bearbeiten</button></li>
                    </ol>
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
            </div>
        </>
    )
}