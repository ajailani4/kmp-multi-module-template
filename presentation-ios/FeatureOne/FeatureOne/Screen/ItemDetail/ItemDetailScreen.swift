import SwiftUI

public struct ItemDetailScreen: View {
    public init() {}
    
    @StateObject private var viewModel = ItemDetailView()
    
    public var body: some View {
        VStack {
            Button(action: { viewModel.getItemDetail() }) {
                Text("Get item")
            }
            .padding(.bottom, 20)
            
            if viewModel.uiState.isLoading {
                ProgressView()
                    .frame(maxWidth: .infinity, alignment: .center)
            }
            
            if let item = viewModel.uiState.item {
                HStack {
                    Text("Id: \(item.id)\nName: \(item.name)")
                        .foregroundStyle(.white)
                }
                .frame(maxWidth: .infinity, alignment: .leading)
                .padding(10)
                .background(Color.accentColor)
                .clipShape(RoundedRectangle(cornerRadius: 10))
            
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding(20)
    }
}
