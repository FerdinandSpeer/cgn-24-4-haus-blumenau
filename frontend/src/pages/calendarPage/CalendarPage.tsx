import CalendarComponent from "../../components/calendar/CalendarComponent.tsx";
import NavBar from "../../components/navBar/NavBar.tsx";

type CalendarPageProps = {
    setArrivalDate: (arrivalDate: string) => void;
    setDepartureDate: (departureDate: string) => void;
}

export default function CalendarPage(props: CalendarPageProps) {


    return (
        <>
            <NavBar/>
            <div>
                <CalendarComponent setArrivalDate={props.setArrivalDate} setDepartureDate={props.setDepartureDate}/>
            </div>
        </>

    );
}