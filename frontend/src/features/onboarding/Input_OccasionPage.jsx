import { theme } from "../../styles/theme";
import { useNavigate, useSearchParams } from "react-router-dom";
import { useState } from "react";
import HeaderBar from "../../components/ui/HeaderBar";
import ProgressBar from "../../components/ui/ProgressBar";
import AppButton from "../../components/ui/AppButton";
import OccasionTile from "../../components/ui/OccasionTile";

export default function OccasionPage() {
    const navigate = useNavigate();
    const [searchParams] = useSearchParams();
    const gender = searchParams.get("gender");
    const [selectedOccasion, setSelectedOccasion] = useState(null);
  return (
        <main
            style={{
                height: "100vh",
                width: "100%",
                overflow: "scroll",
                background: theme.colors.page,
                color: theme.colors.text,
                fontFamily: theme.fonts.sans,
            }}
        >

            <HeaderBar>
                <ProgressBar step={2} />
            </HeaderBar>

        
            <section>
                <h1
                    style={{
                        justifyContent: "center",
                        display: "flex",
                        fontFamily: theme.fonts.display,
                        fontSize: theme.fontSizes.onboardingTitle,
                        fontWeight: theme.fontWeights.regular,
                        lineHeight: theme.lineHeights.tight,
                        color: theme.colors.text,
                    }}
                >
                    Tell us about your day.
                </h1>
                <p
                    style={{
                        justifyContent: "center",
                        display: "flex",
                        fontFamily: theme.fonts.sans,
                        fontSize: theme.fontSizes.onboardingTagline,
                        fontWeight: theme.fontWeights.light,
                        lineHeight: theme.lineHeights.normal,
                        color: theme.colors.mutedText,
                    }}
                >
                    We’ll build an outfit around your plans and weather.
                </p>
                <h1
                    style={{
                            justifyContent: "center",
                            display: "flex",
                            fontFamily: theme.fonts.display,
                            fontWeight: theme.fontWeights.regular,
                            fontSize: "53px",
                            lineHeight: theme.lineHeights.tight,
                            color: theme.colors.text,
                            }}>
                                What's the occasion? 
                </h1>

                <section
                    style={{
                        padding: "5px",
                        display: "flex",
                        flexDirection: "column",
                        gap: "28px",
                        width: "min(760px, 92%)",
                        margin: "0 auto",
                        alignItems: "center",
                    }}
                >
                    <OccasionTile
                    options={["Formal", "Casual", "No Preference"]} //add more options here
                    onSelect={(label) => {
                        console.log("Selected occasion:", label);
                        setSelectedOccasion(label.toLowerCase());
                    }}                    
                    style={{ width: "100%" }}
                    />
                    <AppButton
                    disabled={selectedOccasion === null}
                    onClick={() =>
                        selectedOccasion !== null
                        ? navigate(`/builder?occasion=${selectedOccasion}&gender=${gender}`)
                        : null
                    }
                    >
                    Continue
                    </AppButton>
                </section>
            </section>

        </main>
    );
}