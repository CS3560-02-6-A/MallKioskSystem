import { theme } from "../../styles/theme";

export default function OutfitCategoryCard({ item }) {
    if (!item) return null;
    return (
        <div
            style = {{
                backgroundColor: theme.colors.offWhite,
                border: '1.5px solid ${theme.colors.lightBrown}',
                borderRadius: "12px",
                padding: "16px 20px",
                display: "flex",
                flexDirection: "column",
                gap: "6px",
                width: "100%",
                boxShadow: theme.shadows.dropShadow,
                overflow: "scroll" //not sure if needed
            }}
            >
                <img 
                style = {{ width: "50%", height: "auto"}} //image placeholder
                src = {item.imageSrc}></img>
                <p style = {{ margin: 0, /*item name*/
                    fontFamily: theme.fonts.display, 
                    fontSize:theme.fontSizes.onboardingTagline, 
                    fontWeight: theme.fontWeights.bold, 
                    color: theme.colors.text}}>
                    {item.name}
                </p>
                <p style = {{ //item category and color
                    margin: 0,
                    fontFamily: theme.fonts.sans, 
                    fontSize: theme.fontSizes.onboardingLink, 
                    color: theme.colors.lightBrown }}>
                        {item.type} : {item.color}
                </p>
                <p style = {{ //item gender, not sure if this is needed for backend/filter
                    margin: 0,
                    fontFamily: theme.fonts.sans, 
                    fontSize: theme.fontSizes.onboardingLink, 
                    color: theme.colors.lightBrown }}>
                        {item.gender}
                </p>
                <p style = {{ //store and aisle info
                    margin: 0,
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingLink,
                    color: theme.colors.text }}>
                        Store #{item.storeId} , Aisle {item.aisle}
                </p>
                <p style = {{ //item price rounded to 2 decimals
                    margin: 0,
                    fontFamily: theme.fonts.sans,
                    fontSize: "clamp(15px, 1.2vw, 20px)",
                    fontWeight: theme.fontWeights.bold,
                    color: theme.colors.text }}>
                        ${item.price.toFixed(2)}
                </p>
        </div>
    );
}