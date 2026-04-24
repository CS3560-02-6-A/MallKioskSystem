import { theme } from "../../../styles/theme";
import { useNavigate } from "react-router-dom";
import HeaderBar from "../../../components/ui/HeaderBar";
import ProgressBar from "../../../components/ui/ProgressBar";

export default function OccasionPage() {
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
        <HeaderBar > 
            <ProgressBar step={2}/>
        </HeaderBar>
    </main>
    );
}