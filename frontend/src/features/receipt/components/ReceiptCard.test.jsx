import { render, screen } from '@testing-library/react'
import { describe, it, expect } from 'vitest'
import ReceiptCard from './ReceiptCard'
import { mockOutfitItems } from '../mockData'

describe('ReceiptCard', () => {
  it('renders the "Outfit Items" heading', () => {
    render(<ReceiptCard items={mockOutfitItems} />)
    expect(screen.getByRole('heading', { name: /outfit items/i })).toBeInTheDocument()
  })

  it('renders every item name', () => {
    render(<ReceiptCard items={mockOutfitItems} />)
    for (const item of mockOutfitItems) {
      expect(screen.getByText(item.name)).toBeInTheDocument()
    }
  })

  it('displays the correct total for multiple items', () => {
    render(<ReceiptCard items={mockOutfitItems} />)
    const total = mockOutfitItems.reduce((sum, i) => sum + i.price, 0)
    expect(screen.getByText(`$${total.toFixed(2)}`)).toBeInTheDocument()
  })

  it('displays the correct total for a single item', () => {
    const single = [mockOutfitItems[0]]
    render(<ReceiptCard items={single} />)
    expect(screen.getByText(`$${single[0].price.toFixed(2)}`)).toBeInTheDocument()
  })

  it('shows $0.00 total for an empty list', () => {
    render(<ReceiptCard items={[]} />)
    expect(screen.getByText('$0.00')).toBeInTheDocument()
  })
})