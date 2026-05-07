import { theme } from "../../../styles/theme";

export default function OutfitCategoryCard({ item, category, onSelectItem, isSelected }) {
    if (!item) return null;
    return (
        <button
            type="button"
            aria-pressed={isSelected}
            onClick={() => onSelectItem(category, item)}
            style={{
                backgroundColor: theme.colors.offWhite,
                border: `1.5px solid ${theme.colors.lightBrown}`,
                borderColor: isSelected ? theme.colors.text : theme.colors.lightBrown,
                borderWidth: isSelected ? "2px" : "1.5px",
                borderRadius: "12px",
                padding: "16px 20px",
                display: "flex",
                flexDirection: "column",
                gap: "6px",
                width: "calc(33.333% - 14px)",
                minWidth: "200px",
                boxShadow: theme.shadows.dropShadow,
                cursor: "pointer",
                transition: "all 0.2s ease",
                textAlign: "left",
            }}
            >
                {item.imageSrc && (
                    <img
                        style={{ width: "50%", height: "auto" }}
                        src={item.imageSrc}
                        alt={item.name}
                    />
                )}
                <p style={{
                    margin: 0,
                    fontFamily: theme.fonts.display,
                    fontSize: theme.fontSizes.onboardingTagline,
                    fontWeight: theme.fontWeights.bold,
                    color: theme.colors.text,
                }}>
                    {item.name}
                </p>
                <p style={{
                    margin: 0,
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingLink,
                    color: theme.colors.lightBrown,
                }}>
                    {item.type} : {item.color}
                </p>
                {item.gender && (
                    <p style={{
                        margin: 0,
                        fontFamily: theme.fonts.sans,
                        fontSize: theme.fontSizes.onboardingLink,
                        color: theme.colors.lightBrown,
                    }}>
                        {item.gender}
                    </p>
                )}
                <p style={{
                    margin: 0,
                    fontFamily: theme.fonts.sans,
                    fontSize: theme.fontSizes.onboardingLink,
                    color: theme.colors.text,
                }}>
                    Store #{item.storeId} , Aisle {item.aisle}
                </p>
                <p style={{
                    margin: 0,
                    fontFamily: theme.fonts.sans,
                    fontSize: "clamp(15px, 1.2vw, 20px)",
                    fontWeight: theme.fontWeights.bold,
                    color: theme.colors.text,
                }}>
                    ${item.price.toFixed(2)}
                </p>
        </button>
    );
}