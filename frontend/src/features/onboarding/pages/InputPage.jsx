import { theme } from "../../../styles/theme";
import { useNavigate } from "react-router-dom";
import HeaderBar from "../../../components/ui/HeaderBar";
import ProgressBar from "../../../components/ui/ProgressBar";
import AppButton from "../../../components/ui/AppButton";

export default function InputPage({ setShowInputPage }) {
    const navigate = useNavigate();

  return (
    <main
    style={{
        height: "100vh",
        width: "100%",
        overflow: "hidden",
        background: theme.colors.page,
        color: theme.colors.text,
        fontFamily: theme.fonts.sans,
    }}
>
        <HeaderBar leftButton={"Change fit ←"} > 
            <ProgressBar/>
        </HeaderBar>
        <AppButton               
        onClick={() => navigate("/occasion")}
        >
             Continue 
    </AppButton>
    </main>
    );
}