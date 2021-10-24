package hello.JuDang.JUDANG.Service.ShopManagServices.OpenCloseFunc;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenCloseFuncimpl implements OpenCloseFunc{
    private final ShopRepository shopRepository;
    @Override
    public int OpenCloseFunc(String id, String shopName, boolean isOpen) {
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setOpen(isOpen);
        shop.setSellerId(id);

        return shopRepository.update(shop);
    }
}
