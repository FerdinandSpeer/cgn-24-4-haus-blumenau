import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from '@fullcalendar/daygrid'
import {useNavigate} from "react-router-dom";

type CalendarComponentProps = {
    setArrivalDate: (arrivalDate: string) => void;
    setDepartureDate: (departureDate: string) => void;
}

export default function CalendarComponent(props: CalendarComponentProps) {

    const navigate = useNavigate();


    function handleArrivalDateChange(event: React.FormEvent<HTMLInputElement>) {
        props.setArrivalDate (event.currentTarget.value);
    }

    function handleDepartureDateChange(event: React.FormEvent<HTMLInputElement>) {
        props.setDepartureDate (event.currentTarget.value);
    }


        return (
        <>
            <div>
                <FullCalendar
                    locales={"de"}
                    firstDay={"1"}
                    height={"auto"}
                    plugins={[dayGridPlugin]}
                    initialView="dayGridMonth"
                    headerToolbar={{
                        left: 'title',
                        center: '',
                        right: "today prev,next"
                    }}
                    selectable={true}
                />
            </div>
            <form>
                <div>
                    <label htmlFor={"arrivalDate"}>Anreisedatum: </label>
                    <input type={"date"} id="arrivalDate" name="arrivalDate" onChange={handleArrivalDateChange}/>
                </div>
                <div>
                    <label htmlFor={"departureDate"}>Abreisedatum: </label>
                    <input type={"date"} id="departureDate" name="departureDate" onChange={handleDepartureDateChange}/>
                </div>
                <button type="submit" onClick={() => navigate("/bookingPage")}>Bestätigen</button>
            </form>
        </>
    );
}