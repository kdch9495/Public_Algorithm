// https://programmers.co.kr/learn/courses/30/lessons/64061
//  2019 카카오 개발자 겨울 인턴십 : 크레인 인형뽑기 게임

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 연속된 인형들이 제거된 횟수
        Stack<Integer> stack = new Stack<>(); // 인형을 담을 stack 바구니
        
        for(int i=0; i<moves.length; i++){ // 크레인의 이동횟수
            for(int j=0; j<board.length; j++){ // j인덱스를 이용하여 보드의 행을 탐색, 열은 moves의 원소를 이용해 탐석
                if(board[j][moves[i]-1] != 0){ // j행의 moves 크레인 위치의 열에 해당하는 값에 인형이 존재한다면,
                    if(!stack.empty() && stack.peek() == board[j][moves[i]-1]){ // stack이 비어있지 않고, 현재 최상단에 있는 인형과 크레인으로 뽑은 인형이 같다면, *peek(): 최근 추가된(Top) 데이터 조회
                        answer += 2; // 인형들을 제거하는 횟수 증가
                        stack.pop(); // stack에 있는 인형 제거
                    }else{
                        stack.push(board[j][moves[1]-1]); // 그 외의 경우는 인형을 바구니에 담은 후 0으로 초기화
                    }
                    board[j][moves[1]-1] = 0; // 크레인으로 뽑은 인형의 자리를 0으로 초기화
                    break;
                }
            }
        }
        return answer;
    }
}
