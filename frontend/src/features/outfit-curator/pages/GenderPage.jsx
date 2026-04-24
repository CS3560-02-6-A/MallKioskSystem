import { useState } from "react";
import { ArrowRight } from "lucide-react";
import AppButton from "../../../components/ui/AppButton";
import InputPage from "./InputPage";
import { theme } from "../../../styles/theme";
import manImage from "../../../assets/images/man.png";
import manImageSelected from "../../../assets/images/manSelected.png";
import womanImage from "../../../assets/images/woman.png";
import womanImageSelected from "../../../assets/images/womanSelected.png";
import neutralImage from "../../../assets/images/neutral.png";
import neutralImageSelected from "../../../assets/images/neutralSelected.png";

function selectMan(){ /*changes the man image button to the selected man image button, and deselects any other selected image button*/
    return (
        <div>
            <button
                src={manImageSelected}
                alt="man image selected"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={womanImage}
                alt="woman image"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={neutralImage}
                alt="neutral image"
                style={{
                width: "100%",
                maxWidth: "212px",
               maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
        </div>
    )
}
function selectWoman(){ /*changes the woman image button to the selected woman image button, and deselects any other selected image button*/
    return (
        <div>
            <button
                src={manImage}
                alt="man image"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={womanImageSelected}
                alt="woman image selected"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={neutralImage}
                alt="neutral image"
                style={{
                width: "100%",
                maxWidth: "212px",
               maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
        </div>
    )
}
function selectNeutral(){ /*changes the neutral image button to the selected neutral image button, and deselects any other selected image button*/
    return (
        <div>
            <button
                src={manImage}
                alt="man image"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={womanImage}
                alt="woman image"
                style={{
                width: "100%",
                maxWidth: "212px",
                maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
            <button
                src={neutralImageSelected}
                alt="neutral image selected"
                style={{
                width: "100%",
                maxWidth: "212px",
               maxHeight: "272px",
                height: "auto",
                objectFit: "contain",
                display: "block",
                }}
            />
        </div>
    )
}
export default function GenderPage(setShowGenderPage){ /*headers, unselected gender images, and continue button => OccasionPage*/
    return(
        <section> 
            <div>
                <h1
                    style={{
                        margin: "clamp(8px, 1vw, 12px) 0 0 0",
                        fontFamily: theme.fonts.display,
                        fontSize: theme.fontSizes.onboardingTitle,
                        fontWeight: theme.fontWeights.regular,
                        lineHeight: theme.lineHeights.tight,
                        color: theme.colors.text,
                    }}>How would you like to shop?</h1>
                <h2>This filters the catalog.</h2>
            </div>
            <div> 
                <button
                    src={manImage}
                    alt="man image"
                    onClick = {selectMan()}
                    style={{
                    width: "100%",
                    maxWidth: "212px",
                    maxHeight: "272px",
                    height: "auto",
                    objectFit: "contain",
                    display: "block",
                    }}
                />
                <button
                    src={womanImage}
                    alt="woman image"
                    onClick = {selectWoman()}
                    style={{
                    width: "100%",
                    maxWidth: "212px",
                    maxHeight: "272px",
                    height: "auto",
                    objectFit: "contain",
                    display: "block",
                    }}
                />
                <button
                    src={neutralImage}
                    alt="neutral image"
                    onClick = {selectNeutral()}
                    style={{
                    width: "100%",
                    maxWidth: "212px",
                    maxHeight: "272px",
                    height: "auto",
                    objectFit: "contain",
                    display: "block",
                    }}
                />
            </div>
            <AppButton>
                rightIcon={<ArrowRight size={22} strokeWidth={2.8} />}
            </AppButton>
        </section>
    );
}