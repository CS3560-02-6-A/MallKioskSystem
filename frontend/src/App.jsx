import { Routes, Route } from "react-router-dom";
import OnboardingPage from "./features/onboarding/OnboardingPage";
import Input_GenderPage from "./features/onboarding/Input_GenderPage";
import Input_OccasionPage from "./features/onboarding/Input_OccasionPage";
import OutfitBuilderPage from "./features/outfit-curator/OutfitBuilderPage";
import ReceiptPage from "./features/receipt/ReceiptPage";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<OnboardingPage />} />
      <Route path="/gender" element={<Input_GenderPage />} />
      <Route path="/occasion" element={<Input_OccasionPage />} />
      <Route path="/builder" element={<OutfitBuilderPage />} />
      <Route path="/receipt"  element={<ReceiptPage />} />
    </Routes>
  );
}
