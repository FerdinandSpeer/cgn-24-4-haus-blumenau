import {DateCalendar, LocalizationProvider} from "@mui/x-date-pickers";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";

export default function CalendarComponent() {
    return (
        <div>
            <h1>Calendar</h1>
            <p>Calendar will be displayed here:</p>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DateCalendar/>
            </LocalizationProvider>

        </div>
    );
}