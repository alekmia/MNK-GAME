package game;

import java.util.Arrays;
import java.util.Map;
import java.lang.*;


public class HexBoard extends MNKBoard{
    public HexBoard (int n, int k){
        super(n, n, k);
    }

    @Override
    public boolean checkDiag(int x, int y)
    {
        int count = 0;
        for(int i = x - k, j = y + k; i < x + k && j > y - k; i++, j--) {
            while (i >= 0 && j >= 0 && i < m && j < m && field[i][j] == turn) {
                count++;
                i++;
                j--;
            }
            if (count >= k) {
                return true;
            }
            count = 0;
        }
        return false;
    }
}

