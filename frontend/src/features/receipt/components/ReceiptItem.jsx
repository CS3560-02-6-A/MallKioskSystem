// ReceiptItem.jsx

// Receipt component: The individual item itself layout
// Displays Item image, name, location, price

export default function ReceiptItem({ item }) {
  return (
    <div className="receipt-item">

      {/* Item IMAGE */}
      <img src={item.image} alt={item.name} />

      {/* Item NAME + LOCATION */}
      <div className="receipt-item-info">
        <h3>{item.name}</h3>
        <button type="button">{item.location}</button>
      </div>

      {/* Item PRICE */}
      <p className="receipt-price">
        ${item.price.toFixed(2)}
      </p>
    </div>
  );
}